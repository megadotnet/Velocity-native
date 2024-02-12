package com.megadotnet.config;
import org.apache.velocity.runtime.directive.Parse;
import org.apache.velocity.runtime.directive.VelocimacroProxy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.aot.hint.ReflectionHints;
import org.springframework.aot.hint.RuntimeHints;


import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VelocityNativeConfigurationTest {

    @InjectMocks
    private VelocityNativeConfiguration.VelocityHints velocityHints;

    @Mock
    private RuntimeHints runtimeHints;

    @Mock
    private ClassLoader classLoader;

    @BeforeEach
    public void setup() {
        velocityHints = new VelocityNativeConfiguration.VelocityHints();
    }

    @Test
    @DisplayName("Test registerHints method with successful registration")
    public void testRegisterHints_Success() {
        // Arrange
        Set<Class<?>> expectedClasses = getExpectedClasses();
        when(runtimeHints.reflection())
                .thenReturn(new ReflectionHints());

        // Act
        velocityHints.registerHints(runtimeHints, classLoader);

    }


    private Set<Class<?>> getExpectedClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(Parse.class);
        classes.add(VelocimacroProxy.class);
        // Add more classes here as needed for testing
        return classes;
    }
}
