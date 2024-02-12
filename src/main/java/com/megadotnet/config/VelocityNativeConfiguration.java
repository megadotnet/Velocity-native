package com.megadotnet.config;

import org.apache.velocity.runtime.*;
import org.apache.velocity.runtime.directive.*;
import org.apache.velocity.runtime.directive.contrib.For;
import org.apache.velocity.runtime.parser.*;
import org.apache.velocity.runtime.resource.ResourceCacheImpl;
import org.apache.velocity.runtime.resource.ResourceManagerImpl;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.apache.velocity.runtime.resource.loader.FileResourceLoader;
import org.apache.velocity.util.introspection.*;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.ReflectionHints;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * VelocityNativeConfiguration
 * @author peter liu
 * @date 2024-02-12
 * https://graalvm.github.io/native-build-tools/latest/maven-plugin-quickstart.html
 */
@Configuration(proxyBeanMethods = false)
@ImportRuntimeHints(VelocityNativeConfiguration.VelocityHints.class)
public class VelocityNativeConfiguration {

    /**
     * Register runtime hints for the token library
     */
    public static class VelocityHints implements RuntimeHintsRegistrar {
        @Override
        public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
            ReflectionHints ref = hints.reflection();
            try {
                for (Class<?> c : getAtmosphereClasses()) {
                    ref.registerType(c, MemberCategory.values());
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        /**
         * getAtmosphereClasses
         * @return Collection<? extends Class<?>>
         */
        private Collection<? extends Class<?>> getAtmosphereClasses() {
            Set<Class<?>> classes = new HashSet<>();
            classes.add(Parse.class);
            classes.add(VelocimacroProxy.class);
            classes.add(Include.class);
            classes.add(ResourceManagerImpl.class);
            classes.add(FileResourceLoader.class);
            classes.add(ClasspathResourceLoader.class);
            classes.add(ResourceCacheImpl.class);
            classes.add(Scope.class);
            classes.add(StopCommand.class);
            classes.add(Stop.class);
            classes.add(Define.class);
            classes.add(Break.class);
            classes.add(Evaluate.class);
            classes.add(Macro.class);
            classes.add(Block.class);
            classes.add(BlockMacro.class);
            classes.add(For.class);
            classes.add(Foreach.class);
            classes.add(ForeachScope.class);
            classes.add(InputBase.class);
            classes.add(MacroParseException.class);
            classes.add(StandardParser.class);
            classes.add(StandardParserTokenManager.class);
            classes.add(TemplateParseException.class);
            classes.add(Token.class);
            classes.add(TokenMgrError.class);
            classes.add(VelocityCharStream.class);
            classes.add(LogContext.class);
            classes.add(ParserPoolImpl.class);
            classes.add(ParserConfiguration.class);
            classes.add(RuntimeInstance.class);
            classes.add(RuntimeSingleton.class);
            classes.add(VelocimacroManager.class);
            classes.add(UberspectImpl.class);
            classes.add(ClassFieldMap.class);
            classes.add(ClassMap.class);
            classes.add(Info.class);
            classes.add(IntrospectionCacheData.class);
            classes.add(IntrospectionUtils.class);
            classes.add(IntrospectorBase.class);
            classes.add(IntrospectorCache.class);
            classes.add(LinkingUberspector.class);
            classes.add(MethodMap.class);
            classes.add(SecureIntrospectorControl.class);
            classes.add(SecureIntrospectorImpl.class);
            classes.add(TypeConversionHandlerImpl.class);
            classes.add(UberspectImpl.VelGetterImpl.class);
            classes.add(UberspectImpl.VelMethodImpl.class);
            classes.add(UberspectImpl.VelSetterImpl.class);
            classes.add(UberspectPublicFields.class);
            return classes;
        }


    }
}
