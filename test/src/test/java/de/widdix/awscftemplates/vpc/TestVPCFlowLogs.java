package de.nholuongut.awscftemplates.vpc;

import com.amazonaws.services.cloudformation.model.Parameter;
import de.nholuongut.awscftemplates.ACloudFormationTest;
import org.junit.Test;

public class TestVPCFlowLogs extends ACloudFormationTest {

    @Test
    public void test() {
        final String vpcStackName = "vpc-2azs-" + this.random8String();
        final String flowLogsStackName = "vpc-flow-logs-" + this.random8String();
        final String classB = "10";
        try {
            this.createStack(vpcStackName,
                    "vpc/vpc-2azs.yaml",
                    new Parameter().withParameterKey("ClassB").withParameterValue(classB)
            );
            try {
                this.createStack(flowLogsStackName,
                        "vpc/vpc-flow-logs.yaml",
                        new Parameter().withParameterKey("ParentVPCStack").withParameterValue(vpcStackName)
                );
                // TODO how can we check if this stack works?
            } finally {
                this.deleteStack(flowLogsStackName);
            }
        } finally {
            this.deleteStack(vpcStackName);
        }
    }

}
