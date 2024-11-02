package de.nholuongut.awscftemplates.state;

import com.amazonaws.services.cloudformation.model.Parameter;
import de.nholuongut.awscftemplates.ACloudFormationTest;
import org.junit.Test;

public class TestDynamoDB extends ACloudFormationTest {

    @Test
    public void test() {
        final String stackName = "dynamodb-" + this.random8String();
        try {
            this.createStack(stackName,
                    "state/dynamodb.yaml",
                    new Parameter().withParameterKey("PartitionKeyName").withParameterValue("id")
            );
            // TODO how can we check if this stack works?
        } finally {
            this.deleteStack(stackName);
        }
    }

    @Test
    public void testGSI() {
        final String stackName = "dynamodb-" + this.random8String();
        try {
            this.createStack(stackName,
                    "state/dynamodb.yaml",
                    new Parameter().withParameterKey("PartitionKeyName").withParameterValue("id"),
                    new Parameter().withParameterKey("SortKeyName").withParameterValue("timestamp"),
                    new Parameter().withParameterKey("Attribute1Name").withParameterValue("organisation"),
                    new Parameter().withParameterKey("Attribute2Name").withParameterValue("category"),
                    new Parameter().withParameterKey("Index1PartitionKeyName").withParameterValue("timestamp"),
                    new Parameter().withParameterKey("Index2PartitionKeyName").withParameterValue("organisation"),
                    new Parameter().withParameterKey("Index2SortKeyName").withParameterValue("category")
            );
            // TODO how can we check if this stack works?
        } finally {
            this.deleteStack(stackName);
        }
    }

}
