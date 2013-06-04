package ironpeace.operator;

import ironpeace.modelgen.dmdl.model.Middata1;
import ironpeace.modelgen.dmdl.model.Middata2;
import ironpeace.modelgen.dmdl.model.OriginalData;

import com.asakusafw.vocabulary.operator.Branch;
import com.asakusafw.vocabulary.operator.Convert;

public abstract class Part1Operator {
	
	public static enum Type {ONE, TWO, UNKNOWN}
	
	@Branch
	public Type balaced(OriginalData od){
		if(od.getUserTypeAsString().equals("1")){
			return Type.ONE;
		}else if(od.getUserTypeAsString().equals("2")){
			return Type.TWO;
		}else{
			return Type.UNKNOWN;
		}
	}
	
	@Convert
	public Middata1 converted1(OriginalData od){
		Middata1 m1 = new Middata1();
		
		m1.setUserid(od.getUserid());
		m1.setUserType(od.getUserType());
		
		return m1;
	}
	
	@Convert
	public Middata2 converted2(OriginalData od){
		Middata2 m2 = new Middata2();
		
		if(od.getUserTypeAsString().equals("1")){
			m2.setUseridAsString("ONE_" + od.getUseridAsString());
		}else{
			m2.setUseridAsString("TWO_" + od.getUseridAsString());
		}
		
		m2.setUserType(od.getUserType());
		
		return m2;
	}

}
