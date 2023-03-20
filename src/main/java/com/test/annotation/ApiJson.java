package com.test.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.immutables.value.Value;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.immutables.value.Value.Style.ValidationMethod.NONE;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonAnnotationsInside
@Value.Style(addAll = "*",
             builder = "a*",
             depluralize = true,
             get = {"is*", "get*"},
             jdkOnly = true,
             optionalAcceptNullable = true,
             overshadowImplementation = true,
             putAll = "*",
             redactedMask = "***",
             strictBuilder = true,
             validationMethod = NONE)
public @interface ApiJson {}
