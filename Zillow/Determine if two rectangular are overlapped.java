Determine if two rectangular are overlapped

public class overlapRectangle {
        public static boolean check(Node topLeftA, Node topLeftB, Node bottomRightA, Node bottomRightB){
                //左右关系，用x
                if(bottomRightA.x <= topLeftB.x || bottomRightB.x <= topLeftA.x){
                        return false;
                }
                //上下关系，用y
                if(topLeftA.y <= bottomRightB.y || topLeftB.y <= bottomRightA.y){
                        return false;
                }
                return true;
        }
       
        public static class Node {
                double x;
                double y;
                public Node(double x, double y){
                        this.x = x;
                        this.y = y;
                }
        }
}