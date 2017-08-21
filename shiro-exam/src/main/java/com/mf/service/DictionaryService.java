package com.mf.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import com.mf.domain.Dictionary;

public interface DictionaryService {
	
	/**
	 * 添加字典信息
	 * @param dictionary
	 * @return
	 * @throws SQLException
	 */
	public boolean addDictionary(Dictionary dictionary)throws SQLException;
	/**
	 * 根据字典Id删除字典信息
	 * @param dictionaryId
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteDictionary(String dictionaryId)throws SQLException;
	
	/**
	 * 根据字典编码查询字典信息
	 * @param dictionaryId
	 * @return
	 * @throws SQLException
	 */
	public Dictionary getDictionaryById(String dictionaryId)throws SQLException;
	
	
	/**
	 * 根据条件查询字典信息(字典编号，字典名称， 起始记录数，每页的记录数)
	 * @param condition(dictionaryId 字典编号,dictionaryName 字典名称,
	 * 					pageBegin 起始记录数,pageSize 每页的记录数,dictionaryId 上级字典编号)
	 * @return
	 * @throws SQLException
	 */
	public List<Dictionary> getDictionaryByConditon(Map<String,Object> condition) throws SQLException;
	
	/**
	 * 根据条件查询字典的总的记录数(字典编号，字典名称)
	 * @param condition(dictionaryId 字典编号,dictionaryName 字典名称)
	 * @return
	 * @throws SQLException
	 */
	public int getDicCountByConditon(Map<String,Object> condition) throws SQLException;
	
	/**
	 * 修改字典信息
	 * @param dictionary
	 * @return
	 * @throws SQLException
	 */
	public boolean updateDictionary(Dictionary dictionary)throws SQLException;
	
	/**
	 * 根据上级字典编号查询字典信息
	 * @param upDictionaryId(上级字典编号)、pageBegin(起始记录数)、pageSize(返回的记录数)
	 * @return List<Dictionary> (下级字典列表)
	 * @throws SQLException
	 */
	public List<Dictionary> getDictionaryByUpDicId(Map<String,Object> dicCondition) throws SQLException;
	
	/**
	 * 查询全部字典列表
	 * @return List<Dictionary> (全部字典列表)
	 * @throws SQLException
	 */
	public List<Dictionary> getAllDictionary()throws SQLException;
	
	/**
	 * 查询字典树信息
	 * @return List<Map<String,Object>>
	 * 返回的map包括(dictionaryId,dictionaryName,upDictionaryId)
	 * (字典编号，字典名称，上级字典编号)
	 * @throws SQLException
	 */
	public List<Map<String,Object>> getDictionaryTree() throws SQLException;
	/**
	 * 根据上级字典Id查询下一个要插入的下一级字典的编号 
	 * @param upDictionaryId 上级字典Id
	 * @return
	 * @throws SQLException
	 */
	public String getNextDictionaryId(String upDictionaryId) throws SQLException;
	/**
	 * 根据上级字典Id查询最新的一个下级字典信息
	 * @param upDictionaryId 上级字典Id
	 * @return 最新的一个下级字典信息
	 * @throws SQLException
	 */
	public Dictionary getNewDictionary(String upDictionaryId)throws SQLException;

	
	/**
	 * 根据字典名称查询字典编码
	 * @param dictionaryName 字典名称
	 * @return 字典编码
	 * @throws SQLException
	 */
	public  String getCodeByName(String dictionaryName)throws SQLException;

	public List<String> getInstitutionList(Map<String, Object> institutionCon) throws SQLException;
	
	public List<Map<String, Object>> getDicNameByUpDicId(String upDictionaryId) throws SQLException;
}