package com.map.policy;
	
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
	
	public class PolicyManager {
		private Map<String, Policy> hashmap;
		private Map<String, Policy> linkedhashmap;
		private TreeMap<Date, Policy> treemap;
	
		public PolicyManager() {
			hashmap=new HashMap<>();
			linkedhashmap=new LinkedHashMap<>();
			treemap=new TreeMap<>();
		}

		public void addPolicy(Policy policy) {
			hashmap.put(policy.getPolicyNumber(), policy);
			linkedhashmap.put(policy.getPolicyNumber(), policy);
			treemap.put(policy.getExpiryDate(), policy);
			System.out.println("Policy added: " + policy.getPolicyNumber());
			
//			System.out.println();
//			System.out.println(hashmap);
		}

		 public Policy getPolicyByNumber(String policyNumber) {
		        return hashmap.get(policyNumber);
		    }
		 
		 public List<Policy> listPoliciesByPolicyholder(String policyholderName){
			 List<Policy> policies=new ArrayList<Policy>();
			 
			 for(Policy policy:hashmap.values()) {
				 if(policy.getPolicyholderName().equalsIgnoreCase(policyholderName))
				 {
					 policies.add(policy);
				 }
			 }
			 return policies;	 
		 }

		public void removeExpiredPolicies() {
			List<String> expiredpolicies =new ArrayList<>();
			Date now =new Date();
			
			for(Map.Entry<Date, Policy> entry:treemap.headMap(now,true).entrySet()) {
				expiredpolicies.add(entry.getValue().getPolicyNumber());
			}
			
			for(String policynum:expiredpolicies) {
				hashmap.remove(policynum);
				linkedhashmap.remove(policynum);
				treemap.remove(treemap.firstKey());
			}
		}

		public List<Policy> listExpiredPoliciesByDate(int days) {			
			List<Policy> expiringpolicies =new ArrayList<>();
			Date now =new Date();
			Date futuredate=new Date(now.getTime()+(long)days*24*60*60*1000);
			
			for(Map.Entry<Date, Policy> entry:treemap.headMap(futuredate, true).entrySet()) {
				if(entry.getKey().after(now)) {
					expiringpolicies.add(entry.getValue());
				}
			}
			return expiringpolicies;

		}

		public void displayAllPolicies() {
			for(Policy policy:linkedhashmap.values()) {
				System.out.println(policy);
			}
		}
		 
		
	}
	
	
