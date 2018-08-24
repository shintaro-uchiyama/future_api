package xyz.ucwork.future.resolvers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import xyz.ucwork.future.domain.mapper.ext.ExtMembersMapper;
import xyz.ucwork.future.domain.model.Members;
import xyz.ucwork.future.types.RegistMember;
import xyz.ucwork.future.types.RegistMemberResponse;

@Component
public class Mutation implements GraphQLMutationResolver {
    @Autowired
    private ExtMembersMapper extMembersMapper;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public RegistMemberResponse registMember(String name) {
        // テーブルにインサート
        Members insertMembers = new Members();
        insertMembers.setName(name);
        extMembersMapper.insertWithName(insertMembers);
        // レスポンスにセット
        RegistMemberResponse registMemberResponse = new RegistMemberResponse();
        registMemberResponse.setRegistMember(modelMapper.map(insertMembers, RegistMember.class));
        return registMemberResponse;
    }
}
