package ironpeace.jobflow;

import ironpeace.modelgen.dmdl.model.Middata1;
import ironpeace.modelgen.dmdl.model.Middata2;
import ironpeace.modelgen.dmdl.model.OriginalData;
import ironpeace.operator.Part1OperatorFactory;
import ironpeace.operator.Part1OperatorFactory.Balaced;
import ironpeace.operator.Part1OperatorFactory.Converted1;
import ironpeace.operator.Part1OperatorFactory.Converted2;

import com.asakusafw.vocabulary.flow.FlowDescription;
import com.asakusafw.vocabulary.flow.In;
import com.asakusafw.vocabulary.flow.Out;
import com.asakusafw.vocabulary.flow.util.CoreOperatorFactory;

public class Part1JobFlow extends FlowDescription {
	
	final In<OriginalData> od;
	final Out<Middata1> m1;
	final Out<Middata2> m2;
	final CoreOperatorFactory cp = new CoreOperatorFactory();
	
	public Part1JobFlow(
			In<OriginalData> od,
			Out<Middata1> m1,
			Out<Middata2> m2
			){
		this.od = od;
		this.m1 = m1;
		this.m2 = m2;
	}

	@Override
	protected void describe() {
		Part1OperatorFactory op
			= new Part1OperatorFactory();
		
		Balaced balanced
			= op.balaced(od);
		
		cp.stop(balanced.unknown);
		
		Converted1 converted1 = op.converted1(balanced.one);
		
		m1.add(converted1.out);
		
		cp.stop(converted1.original);
		
		Converted2 converted2 = op.converted2(balanced.two);
		
		m2.add(converted2.out);
		
		cp.stop(converted2.original);
	}

}
