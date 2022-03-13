package lab_4_282;

import java.util.*;
public class CycleDetector<V> {
	ArrayList<Set<Integer>> vertexSet = new ArrayList<>();
	
	public CycleDetector(List<V> vertices) {
		
		for(int i=0;i<vertices.size();++i ) {
			
			Set<Integer> l = new LinkedHashSet<>();
			l.add(i);
			vertexSet.add(l);
			
		}
	}
	
	public boolean detectCycle(Integer v1, Integer v2) {
		for(int i=0;i<vertexSet.size();++i) {
			if(vertexSet.get(i).contains(v1) && vertexSet.get(i).contains(v2)) {
				return true;
			}
		}
	    int i=0;
	    for( i=0;i<vertexSet.size();++i) {
	    	if(vertexSet.get(i).contains(v1) ) {
				break;
			}
	    }
	    int j=0;
	    for( j=0;i<vertexSet.size();++j) {
	    	if(vertexSet.get(j).contains(v2) ) {
				break;
			}
	    }
		vertexSet.get(i).addAll(vertexSet.get(j));
		vertexSet.remove(j);
		return false;
	}
	
}
