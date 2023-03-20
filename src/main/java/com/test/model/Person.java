package com.test.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.test.annotation.ApiJson;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.immutables.value.Value;

import java.time.OffsetDateTime;
import java.util.UUID;

import static com.test.model.ImmutablePerson.aPerson;

@ApiJson
@Value.Immutable
public abstract class Person {

    @JsonCreator
    public static Person create(UUID personId, String name, Integer age, OffsetDateTime createdDate, OffsetDateTime lastChangedDate, Long internalVersion) {
        return aPerson().personId(personId)
                        .name(name)
                        .age(age)
                        .createdDate(createdDate)
                        .lastChangedDate(lastChangedDate)
                        .internalVersion(internalVersion)
                        .build();
    }

    @NotNull
    public abstract UUID getPersonId();

    @NotNull
    @Size(min = 1, max = 100)
    public abstract String getName();

    @NotNull
    @Min(0)
    public abstract Integer getAge();

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public abstract OffsetDateTime getCreatedDate();

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public abstract OffsetDateTime getLastChangedDate();

    @NotNull
    public abstract Long getInternalVersion();

}
