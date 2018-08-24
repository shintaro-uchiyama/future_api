package xyz.ucwork.future.resolvers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import xyz.ucwork.future.domain.mapper.ext.ExtMembersMapper;
import xyz.ucwork.future.domain.model.Members;
import xyz.ucwork.future.types.Member;
import xyz.ucwork.future.types.MembersResponse;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private ExtMembersMapper extMembersMapper;
    @Autowired
    private ModelMapper modelMapper;

    public MembersResponse getMembers(String name) {
        // nameからレコード取得
        List<Members> membersRow = extMembersMapper.selectByName(name);
        // レスポンス返却
        MembersResponse membersResponse = new MembersResponse();
        if (!membersRow.isEmpty()) {
            List<Member> members = membersRow.stream().map(member -> modelMapper.map(member, Member.class))
                    .collect(Collectors.toList());
            membersResponse.setMembers(members);
        }
        return membersResponse;
    }
}
