package test.flowpart.testing.flowpart.stage0001;
import com.asakusafw.runtime.core.Result;
import ironpeace.modelgen.dmdl.model.Middata2;
import ironpeace.modelgen.dmdl.model.OriginalData;
import ironpeace.operator.Part1OperatorImpl;
/**
 * {@code [od->Part1Operator.converted2(operator#1619757639)]}の処理を担当するマッププログラムの断片。
 */
@SuppressWarnings("deprecation") public final class MapFragment1 implements Result<OriginalData> {
    private final Result<OriginalData> original;
    private final Result<Middata2> out;
    private Part1OperatorImpl op = new Part1OperatorImpl();
    /**
     * インスタンスを生成する。
     * @param original {@code Part1Operator.converted2#original}への出力
     * @param out {@code Part1Operator.converted2#out}への出力
     */
    public MapFragment1(Result<OriginalData> original, Result<Middata2> out) {
        this.original = original;
        this.out = out;
    }
    @Override public void add(OriginalData result) {
        Middata2 v = this.op.converted2(result);
        this.original.add(result);
        this.out.add(v);
    }
}