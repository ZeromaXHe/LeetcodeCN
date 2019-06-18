//执行用时 :13 ms, 在所有 Java 提交中击败了77.07%的用户
//内存消耗 :37 MB, 在所有 Java 提交中击败了94.43%的用户
class Solution {
    public String simplifyPath(String path) {
        String[] pathArr = path.split("/");
        LinkedList<String> stack = new LinkedList<>();
        for(String s: pathArr){
            if("..".equals(s)){
                if(!stack.isEmpty()) stack.removeLast();
            }
            else if(".".equals(s)||"".equals(s)){}
            else stack.addLast(s);
        }
        if(stack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        for(String s: stack){
            sb.append('/');
            sb.append(s);
        }
        return sb.toString();
    }
}