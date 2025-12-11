public class Codec {

    public String serialize(TreeNode root)
    {
        //What do i need.
        //I need a stringbuilder that continues to build
        if(root == null)
        {
            return "null,";
        }

        String result = root.val+",";
        result += serialize(root.left);
        result += serialize(root.right);
        return result;
    }

    public TreeNode deserilize(String data)
    {
        TreeNode treeNode = new TreeNode(0);
        return treeNode;

    }
}
