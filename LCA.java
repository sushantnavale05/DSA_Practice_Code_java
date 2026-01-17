class TreeNode
{
    int val;
    TreeNode left, right;
    TreeNode(int v){ val = v;}
}
public class LCA 
{
    static TreeNode lca(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root == null || root == p || root == q)
        {
            return root;
        }
        TreeNode left = lca(root.left,p,q);
        TreeNode right = lca(root.right,p,q);

        if(left != null && right != null)
        {
            return root;
        }
        return (left != null) ? left : right;
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);  

        TreeNode ans = lca(root, root.left, root.right);
        System.out.println(ans.val);
    }
    
}
