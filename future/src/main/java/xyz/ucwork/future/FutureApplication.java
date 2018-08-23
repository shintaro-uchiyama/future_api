package xyz.ucwork.future;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import graphql.Scalars;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import xyz.ucwork.future.domain.mapper.MembersMapper;
import xyz.ucwork.future.domain.mapper.ext.ExtMembersMapper;
import xyz.ucwork.future.domain.model.Members;

@SpringBootApplication
@RestController
@MapperScan({ "xyz.ucwork.future.domain.mapper" })
public class FutureApplication {
	@Autowired
	private ExtMembersMapper extMembersMapper;
	@Autowired
	private MembersMapper membersMapper;

	public static void main(String[] args) {
		SpringApplication.run(FutureApplication.class, args);
	}

	@RequestMapping("/")
	public String function() {
		// membersテーブルにインサート
		String name = "testName";
		Members insertMembers = new Members();
		insertMembers.setName(name);
		extMembersMapper.insertWithName(insertMembers);

		// idからレコード取得
		Members members1 = membersMapper.selectByPrimaryKey(insertMembers.getId());
		// nameからレコード取得
		List<Members> members2 = extMembersMapper.selectByName(name);

		// 画面に表示
		return "name from id: " + members1.getName() + "  name from name: " + members2.get(0).getName();
	}

	@Bean
	GraphQLSchema schema() {
		return GraphQLSchema.newSchema()
		        .query(GraphQLObjectType.newObject().name("query").field(
		                field -> field.name("test").type(Scalars.GraphQLString)
		                        .dataFetcher(environment -> "response"))
		                .build())
		        .build();
	}
}
