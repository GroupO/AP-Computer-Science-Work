import java.util.Collection;

public interface MapPT{

   public boolean containsKey(Object key);
   public boolean containsValue(Object value);
   public Object get(Object key);
   public boolean isEmpty();
   public SetPT keySet();
   public Object put(Object key, Object value);
   public Object remove(Object key);
   public int size();
   public Collection values();
}
