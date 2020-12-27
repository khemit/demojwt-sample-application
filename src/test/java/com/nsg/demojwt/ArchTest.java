package com.nsg.demojwt;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.nsg.demojwt");

        noClasses()
            .that()
            .resideInAnyPackage("com.nsg.demojwt.service..")
            .or()
            .resideInAnyPackage("com.nsg.demojwt.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..com.nsg.demojwt.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
