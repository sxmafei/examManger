package com.mf.util;

import java.util.UUID;

public class GetUuid {

	/** 
     * 获得一个UUID 
     * @return String UUID 
     */ 
	   public static String getUUID(){ 
	        String uuid = UUID.randomUUID().toString(); 
	        //去掉“-”符号 
	        //return s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24);
	        return uuid;
	    } 
}
