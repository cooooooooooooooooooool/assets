package com.poscoict.posledger.assets.config;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.ResourceProcessor;

import com.poscoict.posledger.assets.controller.UserController;
import com.poscoict.posledger.assets.model.vo.Page;
import com.poscoict.posledger.assets.model.vo.ResourcesWrapper;
import com.poscoict.posledger.assets.model.vo.UserVo;

@Configuration
public class ResourceProcessorConfiguration {

	@Bean
	public ResourceProcessor<UserVo> userResourceProcessor() {
		return new ResourceProcessor<UserVo>() {

			@Override
			public UserVo process(UserVo user) {
				user.add(linkTo(methodOn(UserController.class).getUser(user.getUserId())).withSelfRel());
				user.add(linkTo(methodOn(UserController.class).getUserList()).withRel("list"));
				return user;
			}
		};
	}

	@Bean
	public ResourceProcessor<Page<UserVo>> userPageResourceProcessor() {
		return new ResourceProcessor<Page<UserVo>>() {

			@Override
			public Page<UserVo> process(Page<UserVo> resource) {

				List<UserVo> list = resource.getList();

				for (UserVo user : list) {
					user.add(linkTo(methodOn(UserController.class).getUser(user.getUserId())).withSelfRel());
				}

				return resource;
			}
		};
	}

	@Bean
	public ResourceProcessor<ResourcesWrapper<UserVo>> userListResourceProcessor() {
		return new ResourceProcessor<ResourcesWrapper<UserVo>>() {

			@Override
			public ResourcesWrapper<UserVo> process(ResourcesWrapper<UserVo> list) {

				for (UserVo user : list.getList()) {
					user.add(linkTo(methodOn(UserController.class).getUser(user.getUserId())).withSelfRel());
				}

				return list;
			}
		};
	}
}
