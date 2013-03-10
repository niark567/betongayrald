//package org.niark;
//
//import java.util.Set;
//
//public enum ProtocolState
//{
//
////	static {
////		CLIENT_END = new ProtocolState(null);
////		
////		Set<ProtocolState> nextStates;
////		
////		nextStates = new HashSet<ProtocolState>();
////		nextStates.add(CLIENT_END);
////		nextStates.add(CLIENT_ACTION);
////		CLIENT_ACTION = new ProtocolState(nextStates);
////		
////		nextStates = new HashSet<ProtocolState>();
////		nextStates.add(CLIENT_ACTION);
////		nextStates.add(CLIENT_END);
////		CLIENT_INIT = new ProtocolState(nextStates);
////	}
//	CLIENT_INIT,
//	CLIENT_ACTION,
//	CLIENT_END;
//
//	private Set<ProtocolState> next;
//	
//	private ProtocolState(Set<ProtocolState> next) {
//		this.next = next;
//	}
//	
//}
