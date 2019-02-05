package com.newjoiner.maven.SpringMVCCustom.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newjoiner.maven.SpringMVCCustom.dao.LineupDao;
import com.newjoiner.maven.SpringMVCCustom.dao.PlayerDetailDao;
import com.newjoiner.maven.SpringMVCCustom.model.Lineup;
import com.newjoiner.maven.SpringMVCCustom.model.PlayerDetail;

@Service("lineupService")
@Transactional
public class LineupServiceImpl implements LineupService {
 
    @Autowired
    private LineupDao dao;
    
    @Autowired
    private PlayerDetailDao playerDetailDao;
     
    @Override
	public List<Lineup> findLineupsByUser(int userId) {
        return dao.findLineupsByUser(userId);
    }
    
    
    @Override
	public List<Lineup> findOptimizedLineup(Map<String,?> requestParams) {
         List<PlayerDetail> players = playerDetailDao.findAllPlayers(requestParams);
         System.out.println(players.size());
         
         List<PlayerDetail> pointGuards = players.stream()
        		 .filter(player -> player.getPlayer().getPos().equals("PG"))
        		 .collect(Collectors.toList());
         System.out.println("pointGaurds possible : " + pointGuards.size());
         
         List<PlayerDetail> shootingGuards = players.stream()
        		 .filter(player -> player.getPlayer().getPos().equals("SG"))
        		 .collect(Collectors.toList());
         System.out.println("shootingGuards possible : " + shootingGuards.size());
         
         List<PlayerDetail> smallForwards = players.stream()
        		 .filter(player -> player.getPlayer().getPos().equals("SF"))
        		 .collect(Collectors.toList());
         System.out.println("smallForwards possible : " + smallForwards.size());
         
         List<PlayerDetail> powerForwards = players.stream()
        		 .filter(player -> player.getPlayer().getPos().equals("PF"))
        		 .collect(Collectors.toList());
         System.out.println("powerForwards possible : " + powerForwards.size());
         
         List<PlayerDetail> centers = players.stream()
        		 .filter(player -> player.getPlayer().getPos().equals("C"))
        		 .collect(Collectors.toList());
         System.out.println("centers possible : " + centers.size());
        
         List<Integer> pgPlayerIds = new ArrayList<>();
         for (int i = 0; i< pointGuards.size(); i++) {
        	 pgPlayerIds.add(pointGuards.get(i).getId());
         }
//         for (int i : ints) intList.add(i);
//         List<int[]> pgCombos = calcCombos(pgPlayerIds,2);
        
         
         List<Integer> sgPlayerIds = new ArrayList<>();
         for (int i = 0; i< shootingGuards.size(); i++) {
        	 sgPlayerIds.add(shootingGuards.get(i).getId());
         }
         List<Integer> sfPlayerIds = new ArrayList<>();
         for (int i = 0; i< smallForwards.size(); i++) {
        	 sfPlayerIds.add(smallForwards.get(i).getId());
         }
         //List<int[]> sgCombos = calcCombos(sgPlayerIds,2);
        
         //List<int[]> ids = Arrays.asList(pgPlayerIds, sgPlayerIds, sfPlayerIds);
         
         //System.out.println(computeCombinations2(Arrays.asList(pgPlayerIds, sgPlayerIds, sfPlayerIds)));
         
         
         
         //List<int[]> pg_sg_combos = cartesianProduct(pgCombos,sgCombos);
         return dao.findLineupsByUser(1);
    }
//    private char[] type(List<?> combosTest) {
//		// TODO Auto-generated method stub
//		return null;
//	}


//    public static <T> List<List<T>> computeCombinations2(List<List<T>> lists) {
//        List<List<T>> combinations = Arrays.asList(Arrays.asList());
//        for (List<T> list : lists) {
//            List<List<T>> extraColumnCombinations = new ArrayList<>();
//            for (List<T> combination : combinations) {
//                for (T element : list) {
//                    List<T> newCombination = new ArrayList<>(combination);
//                    newCombination.add(element);
//                    extraColumnCombinations.add(newCombination);
//                }
//            }
//            combinations = extraColumnCombinations;
//        }
//        return combinations;
//    }
    
//    public List<int[]> calcCombos(int[] input, int k){
//    	List<int[]> subsets = new ArrayList<>();
//
//    	int[] s = new int[k];                  // here we'll keep indices 
//    	                                       // pointing to elements in input array
//
//    	if (k <= input.length) {
//    		System.out.println(subsets);
//    		System.out.println(s);
//    	    // first index sequence: 0, 1, 2, ...
//    	    for (int i = 0; (s[i] = i) < k - 1; i++);  
//    	    subsets.add(getSubset(input, s));
//    	    System.out.println(subsets.size());
//    	    for(;;) {
//    	        int i;
//    	        // find position of item that can be incremented
//    	        for (i = k - 1; i >= 0 && s[i] == input.length - k + i; i--); 
//    	        if (i < 0) {
//    	            break;
//    	        }
//    	        s[i]++;                    // increment this item
//    	        for (++i; i < k; i++) {    // fill up remaining items
//    	            s[i] = s[i - 1] + 1; 
//    	        }
//    	        subsets.add(getSubset(input, s));
//    	    }
//    	    System.out.println(subsets);
//    	}
//    	return subsets;
//
//    	// generate actual subset by index sequence
//    	
//    	
//    }
    
    
    
//    public List<int[]> cartesianProduct(int[] s1, int[] s2) {
//        List<int[]> list = new ArrayList<int[]>();
//        for (int v1: s1) {
//            for (int v2: s2) {
//                list.add(new int[]{v1, v2});
//            }
//        }
//
//        return list;
//    }
//    int[] getSubset(int[] input, int[] subset) {
//	    int[] result = new int[subset.length]; 
//	    for (int i = 0; i < subset.length; i++) 
//	        result[i] = input[subset[i]];
//		return result;
//	    
//	}
    

	@Override
	public Lineup findById(int lineupId) {
        return dao.findById(lineupId);
    }
    
    @Override
	public Lineup saveLineup(Lineup lineup){
    	dao.saveLineup(lineup);
    	return dao.findById(lineup.getId());
    }
    
    @Override
	public void updateLineup(Lineup lineup){
    	dao.saveOrUpdate(lineup);

    }

    @Override
	public void deleteLineup(int lineupId){
    	Lineup lineup = dao.findById(lineupId);
    	dao.deleteLineup(lineup);
    }
    
    
    
}
