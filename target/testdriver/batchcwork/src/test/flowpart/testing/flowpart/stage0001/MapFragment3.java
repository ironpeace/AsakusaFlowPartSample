package test.flowpart.testing.flowpart.stage0001;
import com.asakusafw.runtime.core.Result;
import ironpeace.modelgen.dmdl.model.OriginalData;
import ironpeace.operator.Part1Operator;
import ironpeace.operator.Part1OperatorImpl;
/**
 * {@code [od->Part1Operator.balaced(operator#1408732008)]}の処理を担当するマッププログラムの断片。
 */
@SuppressWarnings("deprecation") public final class MapFragment3 implements Result<OriginalData> {
    private final Result<OriginalData> one;
    private final Result<OriginalData> two;
    private final Result<OriginalData> unknown;
    private Part1OperatorImpl op = new Part1OperatorImpl();
    /**
     * インスタンスを生成する。
     * @param one {@code Part1Operator.balaced#one}への出力
     * @param two {@code Part1Operator.balaced#two}への出力
     * @param unknown {@code Part1Operator.balaced#unknown}への出力
     */
    public MapFragment3(Result<OriginalData> one, Result<OriginalData> two, Result<OriginalData> unknown) {
        this.one = one;
        this.two = two;
        this.unknown = unknown;
    }
    @Override public void add(OriginalData result) {
        Part1Operator.Type v = this.op.balaced(result);
        switch(v) {
            case ONE:
                this.one.add(result);
                break;
            case TWO:
                this.two.add(result);
                break;
            case UNKNOWN:
                this.unknown.add(result);
                break;
            default:
                throw new AssertionError(v);
        }
    }
}