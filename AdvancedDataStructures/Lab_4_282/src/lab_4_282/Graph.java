package lab_4_282;

import java.util.*;
import java.io.*;
public class Graph<V> {
	private  List<V> vertices = new ArrayList<>();
	private  List<List<Edge>> neighbors 
    = new ArrayList<>(); // Adjacency lists
	
	public  boolean[] visited; 
	public  Queue<V> traversalQueue; 
	public  Stack<V> vertexStack; 
	public  Queue<V> vertexQueue; 
	
	public Graph(V[] vertices, int[][] edges) {
		this.vertices = new ArrayList<>(Arrays.asList(vertices));
		createGraph(this.vertices, edges);
	}
	public  void createGraph(List<V> vertices, int[][] edges) {
		for(int i=0;i<vertices.size();++i) 
			 neighbors.add(new ArrayList<Edge>());
		
		
				for(int i=0;i<edges.length;++i) {
					neighbors.get(edges[i][0]).add(new WeightedEdge(edges[i][0],edges[i][1],edges[i][2]));
				}
				
			
	}	
	public  void dfs(V startVertex) {
		visited = new boolean[vertices.size()];
		traversalQueue = new LinkedList<>();
		vertexStack = new Stack<>();
		vertexQueue = new LinkedList<>();
		visited[vertices.indexOf(startVertex)]=true;
		traversalQueue.offer(startVertex);
		vertexStack.push(startVertex);
	
		while (!vertexStack.isEmpty()) {
			V topVertex = vertexStack.peek();
			List<Edge> nextNeighbor = neighbors.get(vertices.indexOf(topVertex));
			    int i;
				for( i=0;i<nextNeighbor.size();++i) {
					Edge edge = nextNeighbor.get(i);
					int index = edge.v;
					if (!visited[index]) {
						
						visited[index]=true;
						traversalQueue.offer(vertices.get(index));
						vertexStack.push(vertices.get(index));
						break;
					}
				}
			    if(i==nextNeighbor.size())
				vertexStack.pop();
					
			}
		System.out.println( traversalQueue);
		}
	public  void bfs(V startVertex) {
		visited = new boolean[vertices.size()];
		traversalQueue = new LinkedList<>();
		vertexStack = new Stack<>();
		vertexQueue = new LinkedList<>();
		visited[vertices.indexOf(startVertex)]=true;
		traversalQueue.offer(startVertex);
		vertexQueue.offer(startVertex);
		
		while (!vertexQueue.isEmpty()) {
			V frontVertex = vertexQueue.remove();
			List<Edge> nextNeighbor = neighbors.get(vertices.indexOf(frontVertex));
			int i;    
			for(i=0;i<nextNeighbor.size();++i) {
				Edge edge = nextNeighbor.get(i);
				int index = edge.v;
					if (!visited[index]) {
						
						visited[index]=true;
						traversalQueue.offer(vertices.get(index));
						vertexQueue.offer(vertices.get(index));
						
					}
				}
			}
		
					
			
		System.out.println( traversalQueue);
		}
	public void primMST(V startVertex) {
		LinkedList<V> v = new LinkedList<>(vertices);
		LinkedList<V> t = new LinkedList<>();
		LinkedList<WeightedEdge> mst = new LinkedList<>();
		double totalWeight = 0;
		t.add(startVertex);
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		List<Edge> nextNeighbor = neighbors.get(vertices.indexOf(startVertex));
		for(int i=0;i<nextNeighbor.size();++i)
		pq.offer(nextNeighbor.get(i));
		while(t.size()<vertices.size()) {
			WeightedEdge e = (WeightedEdge)pq.poll();
			while(t.contains(vertices.get(e.v))) e=(WeightedEdge)pq.poll();
			t.add(vertices.get(e.v));
			mst.add(e);totalWeight += e.weight;
			nextNeighbor = neighbors.get(e.v);
			for(int i=0;i<nextNeighbor.size();++i)
			pq.offer(nextNeighbor.get(i));
			
		}
		
		//System.out.println(mst);
		System.out.print("[");
		for(int i=0;i<mst.size()-1;++i) {
			System.out.print("{"+vertices.get(mst.get(i).u)+","+vertices.get(mst.get(i).v)+","+mst.get(i).weight+"}, ");
		}
		System.out.println("{"+vertices.get(mst.get(mst.size()-1).u)+","+vertices.get(mst.get(mst.size()-1).v)+","+mst.get(mst.size()-1).weight+"}]");
		System.out.println("Total cost of MST "+totalWeight);
		
		
	}
	@SuppressWarnings("unchecked")
	public void kruskalMST()
	{
		PriorityQueue<Edge> edgeList = new PriorityQueue<>();
	
		//Graph<String> mst = new Graph<>();
		LinkedList<V> v = new LinkedList<>(vertices);
		Set<V> t = new LinkedHashSet<>();
		LinkedList<WeightedEdge> mst = new LinkedList<>();
		
		for(int i=0;i<vertices.size();++i) {
			neighbors.get(i).forEach(e->edgeList.add(e));
			
		}
		double totalWeight = 0;
		@SuppressWarnings("rawtypes")
		CycleDetector cd = new CycleDetector(vertices);
		while(mst.size()!=v.size()-1) {
		
			WeightedEdge e = (WeightedEdge)edgeList.remove();
			if(!cd.detectCycle(e.u,e.v)) {
			
				mst.add(e);totalWeight += e.weight;
				t.add(v.get(e.v));
				t.add(v.get(e.u));
			}
			
		}
		System.out.print("[");
		for(int i=0;i<mst.size()-1;++i) {
			System.out.print("{"+vertices.get(mst.get(i).u)+","+vertices.get(mst.get(i).v)+","+mst.get(i).weight+"}, ");
		}
		System.out.println("{"+vertices.get(mst.get(mst.size()-1).u)+","+vertices.get(mst.get(mst.size()-1).v)+","+mst.get(mst.size()-1).weight+"}]");
		System.out.println("Total cost of MST "+totalWeight);
		
	}
        public void shortestPath(V startVertex, V endVertex) {
            Deque<V> curP = new LinkedList();
            double curD;
            double[] optD = new double[vertices.size()];
            int[] source = new int[vertices.size()];
            Queue<V> optP[] = new LinkedList[vertices.size()];
            Queue<V> parents = new LinkedList();
            PriorityQueue<V> children = new PriorityQueue();
            V parent;
            
            for (int i = 0; i < vertices.size(); i++) {
                optD[i] = Double.MAX_VALUE;
            }
            source[vertices.indexOf(startVertex)] = vertices.indexOf(startVertex);
            parents.add(startVertex);
            optD[vertices.indexOf(startVertex)] = 0;
            Deque<V> ignition = new LinkedList();
            ignition.offer(startVertex);
            optP[vertices.indexOf(startVertex)] = new LinkedList<>(ignition);
            while (!parents.isEmpty()) {
                parent = parents.poll();
                curP.offer(parent);
                List<Edge> parentConnections = neighbors.get(vertices.indexOf(parent));
                parentConnections.forEach((parentConnection) -> {
                    children.offer(vertices.get(parentConnection.v));
                });
                curP = new LinkedList<>(optP[vertices.indexOf(parent)]);
                for (V child : children) {
                    curP.offer(child);
                    int childIndex = vertices.indexOf(child);
                    source[childIndex] = vertices.indexOf(parent);
                    WeightedEdge weChild = (WeightedEdge)parentConnections.get(parentConnections.indexOf(new Edge(vertices.indexOf(parent), vertices.indexOf(child))));
                    double childWeight = weChild.weight;
                    curD = optD[vertices.indexOf(parent)] + childWeight;
                    if (curD < optD[childIndex]) {
                        optD[childIndex] = curD;
                        optP[childIndex] = new LinkedList<>(curP);
                        parents.offer(vertices.get(childIndex));
                    }
                    while (!curP.peekLast().equals(vertices.get(source[childIndex]))) {
                        curP.pollLast();
                    }
                }
                children.clear();
            }
            System.out.println("Cost of shortest path is " + optD[vertices.indexOf(endVertex)]);
            while (!optP[vertices.indexOf(endVertex)].isEmpty()) {
                System.out.print(optP[vertices.indexOf(endVertex)].poll());
                if (!optP[vertices.indexOf(endVertex)].isEmpty()) {
                    System.out.print("->");
                }
            }System.out.println("");
        }
	
	
	public void printGraph() {
		for(int i=0;i<vertices.size();++i) {
			System.out.print(vertices.get(i)+":");
			System.out.println(neighbors.get(i));
		}
	}
	}


