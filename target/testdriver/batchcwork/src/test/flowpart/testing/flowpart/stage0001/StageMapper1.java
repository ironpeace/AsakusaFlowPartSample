package test.flowpart.testing.flowpart.stage0001;
import com.asakusafw.runtime.core.Result;
import com.asakusafw.runtime.flow.RuntimeResourceManager;
import com.asakusafw.runtime.flow.VoidResult;
import com.asakusafw.runtime.stage.output.StageOutputDriver;
import ironpeace.modelgen.dmdl.model.Middata1;
import ironpeace.modelgen.dmdl.model.Middata2;
import ironpeace.modelgen.dmdl.model.OriginalData;
import java.io.IOException;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Mapper;
/**
 * {@code 
         * [od->Part1Operator.balaced(operator#1428983720){owner=FlowBlock&#64;1259649067}, od->Part1Operator.converted2(operator#1619757639){owner=FlowBlock&#64;1259649067}]
         * }の処理を担当するマッププログラム。
 */
@SuppressWarnings("deprecation") public final class StageMapper1 extends Mapper<NullWritable, OriginalData, NullWritable
        , NullWritable> {
    private OriginalData cache = new OriginalData();
    private RuntimeResourceManager runtimeResourceManager;
    private StageOutputDriver outputs;
    private MapFragment1 line1;
    private MapFragment2 line;
    @Override public void setup(Context context) throws IOException, InterruptedException {
        this.runtimeResourceManager = new RuntimeResourceManager(context.getConfiguration());
        this.runtimeResourceManager.setup();
        this.outputs = new StageOutputDriver(context);
        final Result<Middata1> output = outputs.getResultSink("result0");
        final MapFragment3 line0 = new MapFragment3(new VoidResult<OriginalData>(), output);
        this.line = new MapFragment2(line0, new VoidResult<OriginalData>(), new VoidResult<OriginalData>());
        final Result<Middata2> output0 = outputs.getResultSink("result10");
        this.line1 = new MapFragment1(new VoidResult<OriginalData>(), output0);
    }
    @Override public void cleanup(Context context) throws IOException, InterruptedException {
        this.runtimeResourceManager.cleanup();
        this.runtimeResourceManager = null;
        this.outputs.close();
        this.outputs = null;
        this.line1 = null;
        this.line = null;
    }
    @Override public void run(Context context) throws IOException, InterruptedException {
        this.setup(context);
        while(context.nextKeyValue()) {
            cache.copyFrom(context.getCurrentValue());
            this.line.add(cache);
            cache.copyFrom(context.getCurrentValue());
            this.line1.add(cache);
        }
        this.cleanup(context);
    }
}