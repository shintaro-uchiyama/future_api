package xyz.ucwork.future.types;

import java.util.List;

import lombok.Data;

@Data
public class RegistMemberResponse {

	private RegistMember registMember;
	private List<Error> errors;
}
