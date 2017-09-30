import java.util.*;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toCollection;

public class Main {
  public static void main(String[] args) {
    Node child4 =  new Node(2);
    Node child5 =  new Node(3);
    Node child6 =  new Node(4);


    Node child1 =  new Node(5, child4, child5);
    Node child2 =  new Node(6, child6);
    Node child3 =  new Node(7);

    Node parent = new Node(1, child1, child2, child3);

    List<Node> allChildrenAndMe = getAllChildrenAndMe(parent);

    System.out.println(sumAllValues(allChildrenAndMe));
  }

  private static Integer sumAllValues(List<Node> nodes) {
    return nodes
      .stream()
      .map(Node::getValue)
      .reduce((a, b) -> a + b)
      .orElse(0);
  }

  private static List<Node> getAllChildrenAndMe(Node node) {
    return node.getChildren()
      .stream()
      .map(Main::getAllChildrenAndMe)
      .flatMap(List::stream)
      .collect(toCollection(() -> new ArrayList<Node>(asList(node))));
  }
}
