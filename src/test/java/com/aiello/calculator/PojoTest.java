package com.aiello.calculator;

import com.openpojo.reflection.PojoClass;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.*;
import com.openpojo.validation.test.impl.DefaultValuesNullTester;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.openpojo.reflection.impl.PojoClassFactory.getPojoClasses;

/**
 * The purpose of this test class is to test each of the POJO objects in package namespace "com.aiello.calculator.pojo"
 */
@Test(groups = "unit")
public class PojoTest {

    // The package to be tested
    private static final String PACKAGE_NAMESPACE = "com.aiello.calculator.pojo";
    private Validator validator;

    @BeforeClass
    public void setup() {
        validator = ValidatorBuilder.create()
                .with(
                        // Lets make sure that we have a getter and a setter for every field defined.
                        new SetterMustExistRule(),
                        new GetterMustExistRule(),
                        new NoPublicFieldsExceptStaticFinalRule(),
                        new NoFieldShadowingRule(),
                        new NoNestedClassRule(),
                        new NoStaticExceptFinalRule())
                .with(
                        // Lets also validate that they are behaving as expected
                        new SetterTester(),
                        new GetterTester(),
                        new DefaultValuesNullTester()
                )
                .build();
    }


    @Test
    public void testPojoStructureAndBehavior() throws Exception {
        final List<PojoClass> pojos = getPojoClasses(PACKAGE_NAMESPACE);
        validator.validate(pojos);
    }
}
