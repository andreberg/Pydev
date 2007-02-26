package org.python.pydev.refactoring.ui.model.constructorfield;

import java.util.ArrayList;
import java.util.List;

import org.python.pydev.refactoring.ast.adapters.ClassDefAdapter;
import org.python.pydev.refactoring.ast.adapters.SimpleAdapter;
import org.python.pydev.refactoring.ui.model.tree.ITreeNode;
import org.python.pydev.refactoring.ui.model.tree.TreeNodeSimple;

public class TreeNodeClassField extends TreeNodeSimple<ClassDefAdapter> {

	public TreeNodeClassField(ClassDefAdapter adapter) {
		super(null, adapter);
	}
	
	@Override
	public Object[] getChildren() {
		List<ITreeNode> children = new ArrayList<ITreeNode>();
		for (SimpleAdapter attribute : this.adapter.getAttributes()) {
			children.add(new TreeNodeField(this, attribute));
		}
		return children.toArray();
	}
		
	@Override
	public String getImageName() {
		return ITreeNode.NODE_CLASS;
	}
}