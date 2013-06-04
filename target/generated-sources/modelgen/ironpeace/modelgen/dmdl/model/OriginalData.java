package ironpeace.modelgen.dmdl.model;
import com.asakusafw.runtime.model.DataModel;
import com.asakusafw.runtime.model.DataModelKind;
import com.asakusafw.runtime.model.ModelInputLocation;
import com.asakusafw.runtime.model.ModelOutputLocation;
import com.asakusafw.runtime.model.PropertyOrder;
import com.asakusafw.runtime.value.StringOption;
import ironpeace.modelgen.dmdl.io.OriginalDataInput;
import ironpeace.modelgen.dmdl.io.OriginalDataOutput;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
/**
 * OriginalDataを表すデータモデルクラス。
 */
@DataModelKind("DMDL")@ModelInputLocation(OriginalDataInput.class)@ModelOutputLocation(OriginalDataOutput.class)@
        PropertyOrder({"userid", "user_type"}) public class OriginalData implements DataModel<OriginalData>, Writable {
    private final StringOption userid = new StringOption();
    private final StringOption userType = new StringOption();
    @Override@SuppressWarnings("deprecation") public void reset() {
        this.userid.setNull();
        this.userType.setNull();
    }
    @Override@SuppressWarnings("deprecation") public void copyFrom(OriginalData other) {
        this.userid.copyFrom(other.userid);
        this.userType.copyFrom(other.userType);
    }
    /**
     * USERIDを返す。
     * @return USERID
     * @throws NullPointerException USERIDの値が<code>null</code>である場合
     */
    public Text getUserid() {
        return this.userid.get();
    }
    /**
     * USERIDを設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setUserid(Text value) {
        this.userid.modify(value);
    }
    /**
     * <code>null</code>を許すUSERIDを返す。
     * @return USERID
     */
    public StringOption getUseridOption() {
        return this.userid;
    }
    /**
     * USERIDを設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setUseridOption(StringOption option) {
        this.userid.copyFrom(option);
    }
    /**
     * USERTYPEを返す。
     * @return USERTYPE
     * @throws NullPointerException USERTYPEの値が<code>null</code>である場合
     */
    public Text getUserType() {
        return this.userType.get();
    }
    /**
     * USERTYPEを設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setUserType(Text value) {
        this.userType.modify(value);
    }
    /**
     * <code>null</code>を許すUSERTYPEを返す。
     * @return USERTYPE
     */
    public StringOption getUserTypeOption() {
        return this.userType;
    }
    /**
     * USERTYPEを設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setUserTypeOption(StringOption option) {
        this.userType.copyFrom(option);
    }
    @Override public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("{");
        result.append("class=original_data");
        result.append(", userid=");
        result.append(this.userid);
        result.append(", userType=");
        result.append(this.userType);
        result.append("}");
        return result.toString();
    }
    @Override public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + userid.hashCode();
        result = prime * result + userType.hashCode();
        return result;
    }
    @Override public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null) {
            return false;
        }
        if(this.getClass() != obj.getClass()) {
            return false;
        }
        OriginalData other = (OriginalData) obj;
        if(this.userid.equals(other.userid) == false) {
            return false;
        }
        if(this.userType.equals(other.userType) == false) {
            return false;
        }
        return true;
    }
    /**
     * USERIDを返す。
     * @return USERID
     * @throws NullPointerException USERIDの値が<code>null</code>である場合
     */
    public String getUseridAsString() {
        return this.userid.getAsString();
    }
    /**
     * USERIDを設定する。
     * @param userid0 設定する値
     */
    @SuppressWarnings("deprecation") public void setUseridAsString(String userid0) {
        this.userid.modify(userid0);
    }
    /**
     * USERTYPEを返す。
     * @return USERTYPE
     * @throws NullPointerException USERTYPEの値が<code>null</code>である場合
     */
    public String getUserTypeAsString() {
        return this.userType.getAsString();
    }
    /**
     * USERTYPEを設定する。
     * @param userType0 設定する値
     */
    @SuppressWarnings("deprecation") public void setUserTypeAsString(String userType0) {
        this.userType.modify(userType0);
    }
    @Override public void write(DataOutput out) throws IOException {
        userid.write(out);
        userType.write(out);
    }
    @Override public void readFields(DataInput in) throws IOException {
        userid.readFields(in);
        userType.readFields(in);
    }
}