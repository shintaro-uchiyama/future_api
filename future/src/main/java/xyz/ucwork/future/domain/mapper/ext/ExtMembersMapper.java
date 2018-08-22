package xyz.ucwork.future.domain.mapper.ext;

import java.util.List;

import xyz.ucwork.future.domain.model.Members;

/**
 * membersテーブル操作用のmapper.
 * @author uchiyama-shintaro
 *
 */
public interface ExtMembersMapper {

	/**
	 * 名前でmembersテーブルに追加.
	 * @param members
	 * @return
	 */
	int insertWithName(Members members);

	/**
	 * 名前でレコード検索.
	 * @param name
	 * @return
	 */
	List<Members> selectByName(String name);

}
