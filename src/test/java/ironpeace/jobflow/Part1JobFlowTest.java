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
			= tester.input("original_data", OriginalData.class)
				.prepare("original_data.xls#input");
		
		Out<Middata1> m1
			= tester.output("middata1", Middata1.class)
				.prepare("middata1.xls#output");
		
		Out<Middata2> m2
			= tester.output("middata2", Middata2.class)
				.prepare("middata2.xls#output");
		
		FlowDescription flowpart = new Part1JobFlow(od, m1, m2);
		tester.runTest(flowpart);
	}
}
