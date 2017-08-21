package com.mf.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.domain.Dictionary;
import com.mf.mapper.DictionaryMapper;
import com.mf.service.DictionaryService;
import com.mf.util.ValidateCheck;

@Service("dictionaryService")
public class DictionaryServiceImpl implements DictionaryService {

	@Resource
	private DictionaryMapper dictionaryMapper;

	/**
	 * 添加字典信息
	 * @param dictionary
	 * @return
	 * @throws SQLException
	 */
	public boolean addDictionary(Dictionary dictionary)
			throws SQLException {		
		if (dictionary != null) {
			dictionary.setDictionaryid(this.getNextDictionaryId(dictionary.getUpdictionaryid()));
			int addDictionaryResult = dictionaryMapper.insertDictionary(dictionary);

			boolean result = addDictionaryResult > -1 ? true : false;

			return result;

		}
		return false;
	}

	/**
	 * 根据字典Id删除字典信息
	 * 
	 * @param dictionaryId
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteDictionary(String dictionaryId)
			throws SQLException {
		if (dictionaryId != null && !"".equals(dictionaryId)) {
			return dictionaryMapper.deleteDictionary(dictionaryId) > 0 ? true
					: false;
		} else {
			return false;
		}
	}

	/**
	 * 根据字典编码查询字典信息
	 * @param dictionaryId
	 * @return
	 * @throws SQLException
	 */
	public Dictionary getDictionaryById(String dictionaryId)
			throws SQLException {
		if (dictionaryId != null && !"".equals(dictionaryId)) {
			return dictionaryMapper.getDictionaryById(dictionaryId);
		}
		return null;
	}

	/**
	 * 根据条件查询字典信息(字典编号，字典名称， 起始记录数，每页的记录数)
	 * 
	 * @param condition
	 *            (dictionaryId 字典编号,dictionaryName 字典名称, pageBegin
	 *            起始记录数,pageSize 每页的记录数,dictionaryId 上级字典编号)
	 * @return
	 * @throws SQLException
	 */
	public List<Dictionary> getDictionaryByConditon(
			Map<String, Object> condition) throws SQLException {

		if (condition != null) {

			return dictionaryMapper.getDictionaryByConditon(condition);
		}

		return null;
	}

	/**
	 * 根据条件查询字典的总的记录数(字典编号，字典名称)
	 * 
	 * @param condition
	 *            (dictionaryId 字典编号,dictionaryName 字典名称)
	 * @return
	 * @throws SQLException
	 */
	public int getDicCountByConditon(Map<String, Object> condition)
			throws SQLException {

		if (condition != null) {

			return dictionaryMapper.getDicCountByConditon(condition);

		}
		return 0;
	}

	/**
	 * 修改字典信息
	 * 
	 * @param dictionary
	 * @return
	 * @throws SQLException
	 */
	@Transactional
	public boolean updateDictionary(Dictionary dictionary)
			throws SQLException {

		if (dictionary != null) {

			boolean updateResult = false;

			dictionaryMapper.updateChildNotUse(dictionary);
			updateResult = dictionaryMapper.updateDictionary(dictionary) >= 0 ? true
					: false;
			
			
			return updateResult;

		} else {

			return false;
		}
	}

	/**
	 * 根据上级字典编号查询字典信息
	 * 
	 * @param upDictionaryId
	 *            (上级字典编号)、pageBegin(起始记录数)、pageSize(返回的记录数)
	 * @return List<Dictionary> (下级字典列表)
	 * @throws SQLException
	 */
	public List<Dictionary> getDictionaryByUpDicId(
			Map<String, Object> dicCondition) throws SQLException {

		if (dicCondition != null) {

			return dictionaryMapper.getDictionaryByUpDicId(dicCondition);

		} else {

			return null;
		}

	}

	/**
	 * 查询全部字典列表
	 * 
	 * @return List<Dictionary> (全部字典列表)
	 * @throws SQLException
	 */
	public List<Dictionary> getAllDictionary() throws SQLException {

		return dictionaryMapper.getAllDictionary();
	}

	/**
	 * 查询字典树信息
	 * 
	 * @return List<Map<String,Object>>
	 *         返回的map包括(dictionaryId,dictionaryName
	 *         ,upDictionaryId) (字典编号，字典名称，上级字典编号)
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getDictionaryTree() throws SQLException {

		return dictionaryMapper.getDictionaryTree();
	}

	/**
	 * 根据上级字典Id查询下一个要插入的下一级字典的编号
	 * 
	 * @param upDictionaryId
	 *            上级字典Id
	 * @return
	 * @throws SQLException
	 */
	public String getNextDictionaryId(String upDictionaryId)
			throws SQLException {

		boolean result = ValidateCheck.isNotNull(upDictionaryId);

		if (result) {

			String nextId = dictionaryMapper
					.getMaxDictionaryId(upDictionaryId);

			if (nextId == null) {

				nextId = upDictionaryId + "001";

			} else {

				nextId = Integer.toString(Integer.parseInt(nextId) + 1);
			}

			return nextId;

		} else {

			return null;
		}

	}

	/**
	 * 根据上级字典Id查询最新的一个下级字典信息
	 * 
	 * @param upDictionaryId
	 *            上级字典Id
	 * @return 最新的一个下级字典信息
	 * @throws SQLException
	 */
	public Dictionary getNewDictionary(String upDictionaryId)
			throws SQLException {

		boolean result = ValidateCheck.isNotNull(upDictionaryId);

		if (result) {

			return dictionaryMapper.getNewDictionary(upDictionaryId);

		} else {

			return null;
		}

	}

	/**
	 * 根据字典名称查询字典编码
	 * 
	 * @param dictionaryName
	 *            字典名称
	 * @return 字典编码
	 * @throws SQLException
	 */
	public String getCodeByName(String dictionaryName) throws SQLException {
		if(ValidateCheck.isNotNull(dictionaryName)) {
			return dictionaryMapper.getCodeByName(dictionaryName);
		}
		return null;
	}

	public List<String> getInstitutionList(Map<String, Object> institutionCon)
			throws SQLException {
		if(institutionCon != null && institutionCon.size() > 0) {
			return dictionaryMapper.getInstitutionList(institutionCon);
		}
		return null;
	}

	@Override
	public List<Map<String, Object>> getDicNameByUpDicId(String upDictionaryId) throws SQLException {
		if (ValidateCheck.isNotNull(upDictionaryId)) {
			return dictionaryMapper.selectDicNameByUpDicId(upDictionaryId);
		}
		return null;
	}
}
