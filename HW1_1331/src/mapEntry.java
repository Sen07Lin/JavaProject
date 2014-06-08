import java.util.Map.Entry;


public class mapEntry <k,v> implements Entry<k,v>{
    private k key;
    private v value;
    public mapEntry(k key2, v value){
        this.key= key2;
        this.value = value;
    }
    @Override
    public k getKey() {
        // TODO Auto-generated method stub
        return key;
    }
    @Override
    public v getValue() {
        // TODO Auto-generated method stub
        return value;
    }
    @Override
    public v setValue(v arg0) {
        // TODO Auto-generated method stub
        value = arg0;
        return value;

    }
}
