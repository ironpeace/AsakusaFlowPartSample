package test.flowpart.testing.flowpart.stage0001;
import com.asakusafw.runtime.core.Result;
import ironpeace.modelgen.dmdl.model.Middata1;
import ironpeace.modelgen.dmdl.model.OriginalData;
import ironpeace.operator.Part1OperatorImpl;
/**
 * {@code [od->Part1Operator.converted1(operator#162291475)]}の処理を担当するマッププログラムの断片。
 */
@SuppressWarnings("deprecation") public final class MapFragment1 implements Result<OriginalData> {
    private final Result<OriginalData> original;
    private final Result<Middata1> out;
    private Part1OperatorImpl op = new Part1OperatorImpl();
    /**
     * インスタンスを生成する。
     * @param original {@code Part1Operator.converted1#original}への出力
     * @param out {@code Part1Operator.converted1#out}への出力
     */
    public MapFragment1(Result<OriginalData> original, Result<Middata1> out) {
        this.original = original;
        this.out = out;
    }
    @Override public void add(OriginalData result) {
        Middata1 v = this.op.converted1(result);
        this.original.add(result);
        this.out.add(v);
    }
}