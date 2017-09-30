import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Node {
  private Integer value;
  private List<Node> children;

  public Node(Integer value) {
    this.value = value;
    this.children = new ArrayList<>();
  }

  public Node(Integer value, Node... children) {
    this.value = value;
    this.children = children.length > 0 ? Arrays.asList(children) : new ArrayList<>();
  }

  public List<Node> getChildren() {
    return children;
  }

  public Integer getValue() {
    return value;
  }
}
