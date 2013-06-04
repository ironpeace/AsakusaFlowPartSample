package ironpeace.operator;
import com.asakusafw.vocabulary.flow.Operator;
import com.asakusafw.vocabulary.flow.Source;
import com.asakusafw.vocabulary.flow.graph.FlowElementResolver;
import com.asakusafw.vocabulary.flow.graph.ObservationCount;
import com.asakusafw.vocabulary.flow.graph.OperatorDescription;
import com.asakusafw.vocabulary.operator.Branch;
import com.asakusafw.vocabulary.operator.Convert;
import com.asakusafw.vocabulary.operator.OperatorFactory;
import com.asakusafw.vocabulary.operator.OperatorInfo;
import ironpeace.modelgen.dmdl.model.Middata1;
import ironpeace.modelgen.dmdl.model.Middata2;
import ironpeace.modelgen.dmdl.model.OriginalData;
import javax.annotation.Generated;
/**
 * {@link Part1Operator}に関する演算子ファクトリークラス。
 * @see Part1Operator
 */
@Generated("OperatorFactoryClassGenerator:0.0.1")@OperatorFactory(Part1Operator.class) public class Part1OperatorFactory 
        {
    /**
     */
    public static final class Balaced implements Operator {
        private final FlowElementResolver $;
        /**
         */
        public final Source<OriginalData> one;
        /**
         */
        public final Source<OriginalData> two;
        /**
         */
        public final Source<OriginalData> unknown;
        Balaced(Source<OriginalData> od) {
            OperatorDescription.Builder builder = new OperatorDescription.Builder(Branch.class);
            builder.declare(Part1Operator.class, Part1OperatorImpl.class, "balaced");
            builder.declareParameter(OriginalData.class);
            builder.addInput("od", od);
            builder.addOutput("one", od);
            builder.addOutput("two", od);
            builder.addOutput("unknown", od);
            builder.addAttribute(ObservationCount.DONT_CARE);
            this.$ = builder.toResolver();
            this.$.resolveInput("od", od);
            this.one = this.$.resolveOutput("one");
            this.two = this.$.resolveOutput("two");
            this.unknown = this.$.resolveOutput("unknown");
        }
        /**
         * この演算子の名前を設定する。
         * @param newName 設定する名前
         * @return この演算子オブジェクト (this)
         * @throws IllegalArgumentException 引数に{@code null}が指定された場合
         */
        public Part1OperatorFactory.Balaced as(String newName) {
            this.$.setName(newName);
            return this;
        }
    }
    /**
     * @param od
     * @return 生成した演算子オブジェクト
     * @see Part1Operator#balaced(OriginalData)
     */
    @OperatorInfo(kind = Branch.class, input = {@OperatorInfo.Input(name = "od", type = OriginalData.class, position = 0
                )}, output = {@OperatorInfo.Output(name = "one", type = OriginalData.class),@OperatorInfo.Output(name = 
                "two", type = OriginalData.class),@OperatorInfo.Output(name = "unknown", type = OriginalData.class)}, 
            parameter = {}) public Part1OperatorFactory.Balaced balaced(Source<OriginalData> od) {
        return new Part1OperatorFactory.Balaced(od);
    }
    /**
     */
    public static final class Converted1 implements Operator {
        private final FlowElementResolver $;
        /**
         * 入力された内容
         */
        public final Source<OriginalData> original;
        /**
         */
        public final Source<Middata1> out;
        Converted1(Source<OriginalData> od) {
            OperatorDescription.Builder builder0 = new OperatorDescription.Builder(Convert.class);
            builder0.declare(Part1Operator.class, Part1OperatorImpl.class, "converted1");
            builder0.declareParameter(OriginalData.class);
            builder0.addInput("od", od);
            builder0.addOutput("original", od);
            builder0.addOutput("out", Middata1.class);
            builder0.addAttribute(ObservationCount.DONT_CARE);
            this.$ = builder0.toResolver();
            this.$.resolveInput("od", od);
            this.original = this.$.resolveOutput("original");
            this.out = this.$.resolveOutput("out");
        }
        /**
         * この演算子の名前を設定する。
         * @param newName0 設定する名前
         * @return この演算子オブジェクト (this)
         * @throws IllegalArgumentException 引数に{@code null}が指定された場合
         */
        public Part1OperatorFactory.Converted1 as(String newName0) {
            this.$.setName(newName0);
            return this;
        }
    }
    /**
     * @param od
     * @return 生成した演算子オブジェクト
     * @see Part1Operator#converted1(OriginalData)
     */
    @OperatorInfo(kind = Convert.class, input = {@OperatorInfo.Input(name = "od", type = OriginalData.class, position = 
                0)}, output = {@OperatorInfo.Output(name = "original", type = OriginalData.class),@OperatorInfo.Output(
                name = "out", type = Middata1.class)}, parameter = {}) public Part1OperatorFactory.Converted1 converted1
            (Source<OriginalData> od) {
        return new Part1OperatorFactory.Converted1(od);
    }
    /**
     */
    public static final class Converted2 implements Operator {
        private final FlowElementResolver $;
        /**
         * 入力された内容
         */
        public final Source<OriginalData> original;
        /**
         */
        public final Source<Middata2> out;
        Converted2(Source<OriginalData> od) {
            OperatorDescription.Builder builder1 = new OperatorDescription.Builder(Convert.class);
            builder1.declare(Part1Operator.class, Part1OperatorImpl.class, "converted2");
            builder1.declareParameter(OriginalData.class);
            builder1.addInput("od", od);
            builder1.addOutput("original", od);
            builder1.addOutput("out", Middata2.class);
            builder1.addAttribute(ObservationCount.DONT_CARE);
            this.$ = builder1.toResolver();
            this.$.resolveInput("od", od);
            this.original = this.$.resolveOutput("original");
            this.out = this.$.resolveOutput("out");
        }
        /**
         * この演算子の名前を設定する。
         * @param newName1 設定する名前
         * @return この演算子オブジェクト (this)
         * @throws IllegalArgumentException 引数に{@code null}が指定された場合
         */
        public Part1OperatorFactory.Converted2 as(String newName1) {
            this.$.setName(newName1);
            return this;
        }
    }
    /**
     * @param od
     * @return 生成した演算子オブジェクト
     * @see Part1Operator#converted2(OriginalData)
     */
    @OperatorInfo(kind = Convert.class, input = {@OperatorInfo.Input(name = "od", type = OriginalData.class, position = 
                0)}, output = {@OperatorInfo.Output(name = "original", type = OriginalData.class),@OperatorInfo.Output(
                name = "out", type = Middata2.class)}, parameter = {}) public Part1OperatorFactory.Converted2 converted2
            (Source<OriginalData> od) {
        return new Part1OperatorFactory.Converted2(od);
    }
}