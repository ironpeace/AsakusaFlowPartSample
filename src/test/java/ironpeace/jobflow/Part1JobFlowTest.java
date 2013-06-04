package ironpeace.jobflow;

import ironpeace.modelgen.dmdl.model.Middata1;
import ironpeace.modelgen.dmdl.model.Middata2;
import ironpeace.modelgen.dmdl.model.OriginalData;

import org.junit.Test;

import com.asakusafw.testdriver.FlowPartTester;
import com.asakusafw.vocabulary.flow.FlowDescription;
import com.asakusafw.vocabulary.flow.In;
import com.asakusafw.vocabulary.flow.Out;

public class Part1JobFlowTest {

	@Test
	public void testPart1JobFlow(){
		FlowPartTester tester = new FlowPartTester(getClass());
		
		In<OriginalData> od
			= tester.input("originaldata", OriginalData.class)
				.prepare("original_data.xls#input");
		
		Out<Middata1> m1
			= tester.output("middata1", Middata1.class)
				.verify("middata1.xls#output", "middata1.xls#rule");
		
		Out<Middata2> m2
			= tester.output("middata2", Middata2.class)
				.verify("middata2.xls#output", "middata2.xls#rule");
		
		FlowDescription flowpart = new Part1JobFlow(od, m1, m2);
		tester.runTest(flowpart);
	}
}
