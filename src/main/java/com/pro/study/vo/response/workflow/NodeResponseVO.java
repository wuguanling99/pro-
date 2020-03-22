package com.pro.study.vo.response.workflow;

import com.pro.study.vo.response.sys.SysResponseVO;

/**
 * 
* @author: wgl
* @date: 2020年3月22日下午3:13:17 
* @version:1.0
* @Description:节点返回数据
 */
public class NodeResponseVO extends SysResponseVO{
	
	private Long nodeId;

	private String nodeName;

	public NodeResponseVO(Integer code, String message, Long nodeId, String nodeName) {
		super(code, message);
		this.nodeId = nodeId;
		this.nodeName = nodeName;
	}

	public NodeResponseVO(Integer code, String message) {
		super(code, message);
		// TODO Auto-generated constructor stub
	}

	public Long getNodeId() {
		return nodeId;
	}

	public void setNodeId(Long nodeId) {
		this.nodeId = nodeId;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	@Override
	public String toString() {
		return "NodeResponseVO [nodeId=" + nodeId + ", nodeName=" + nodeName + "]";
	}
	
}
