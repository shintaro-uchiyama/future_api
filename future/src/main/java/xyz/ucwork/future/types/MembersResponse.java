package xyz.ucwork.future.types;

import java.util.List;

import lombok.Data;

@Data
public class MembersResponse {

	private List<Member> members;
	private List<Error> errors;

}
