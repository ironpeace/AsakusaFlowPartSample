package test.flowpart.testing.flowpart.temporary.output.epilogue;
import com.asakusafw.runtime.stage.AbstractStageClient;
import com.asakusafw.runtime.stage.StageInput;
import com.asakusafw.runtime.stage.StageOutput;
import com.asakusafw.runtime.stage.collector.SortableSlot;
import com.asakusafw.runtime.stage.collector.WritableSlot;
import com.asakusafw.runtime.stage.input.TemporaryInputFormat;
import com.asakusafw.runtime.stage.output.TemporaryOutputFormat;
import ironpeace.modelgen.dmdl.model.Middata1;
import ironpeace.modelgen.dmdl.model.Middata2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.hadoop.io.NullWritable;
import test.flowpart.testing.flowpart.temporary.output.epilogue.middata1.StageMapper0;
/**
 * "temporary.output"のエピローグステージのジョブを実行するクライアント。
 */
public final class StageClient extends AbstractStageClient {
    @Override protected String getBatchId() {
        return "testing";
    }
    @Override protected String getFlowId() {
        return "flowpart";
    }
    @Override protected String getStageId() {
        return "epilogue.temporary.output";
    }
    @Override protected String getStageOutputPath() {
        return "target/testdriver/hadoopwork/${execution_id}/output";
    }
    @Override protected List<StageInput> getStageInputs() {
        List<StageInput> results = new ArrayList<StageInput>();
        Map<String, String> attributes = null;
        attributes = new HashMap<String, String>();
        results.add(new StageInput(
                "target/testdriver/hadoopwork/${execution_id}/temp/testing/flowpart/stage0001/result0-*", 
                TemporaryInputFormat.class, StageMapper0.class, attributes));
        attributes = new HashMap<String, String>();
        results.add(new StageInput(
                "target/testdriver/hadoopwork/${execution_id}/temp/testing/flowpart/stage0001/result10-*", 
                TemporaryInputFormat.class, test.flowpart.testing.flowpart.temporary.output.epilogue.middata2.
                StageMapper0.class, attributes));
        return results;
    }
    @Override protected List<StageOutput> getStageOutputs() {
        List<StageOutput> results = new ArrayList<StageOutput>();
        results.add(new StageOutput("middata1", NullWritable.class, Middata1.class, TemporaryOutputFormat.class));
        results.add(new StageOutput("middata2", NullWritable.class, Middata2.class, TemporaryOutputFormat.class));
        return results;
    }
    @Override protected Class<SortableSlot> getShuffleKeyClassOrNull() {
        return SortableSlot.class;
    }
    @Override protected Class<WritableSlot> getShuffleValueClassOrNull() {
        return WritableSlot.class;
    }
}