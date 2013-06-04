package ironpeace.operator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import ironpeace.modelgen.dmdl.model.OriginalData;
import ironpeace.operator.Part1Operator.Type;

import org.junit.Test;

public class Part1OperatorTest {

	@Test
	public void balance(){
		OriginalData od1 = getOd("1111", "1");
		OriginalData od2 = getOd("2222", "2");
		OriginalData od99 = getOd("9999", "99");
		
		Part1Operator op = new Part1OperatorImpl();
		
		assertThat(op.balaced(od1), is(Type.ONE));
		assertThat(op.balaced(od2), is(Type.TWO));
		assertThat(op.balaced(od99), is(Type.UNKNOWN));
		
	}
	
	private OriginalData getOd(String id, String type){
		OriginalData od = new OriginalData();
		od.setUseridAsString(id);
		od.setUserTypeAsString(type);
		return od;
	}
}
