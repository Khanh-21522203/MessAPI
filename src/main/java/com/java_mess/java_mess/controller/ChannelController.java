package com.java_mess.java_mess.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java_mess.java_mess.dto.channel.CreateChannelRequest;
import com.java_mess.java_mess.dto.channel.CreateChannelResponse;
import com.java_mess.java_mess.dto.channel.GetChannelResponse;
import com.java_mess.java_mess.model.Channel;
import com.java_mess.java_mess.service.ChannelService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/channels")
public class ChannelController extends BaseController {

	private final ChannelService channelService;

	@GetMapping("{id}")
	public ResponseEntity<GetChannelResponse> getChannelById(@PathVariable String id) {
		Channel channel = channelService.getChannelById(getAuthenticatedApp(), id);
		return ResponseEntity.status(HttpStatus.OK).body(GetChannelResponse.builder().channel(channel).build());
	}

	@GetMapping("{clientReferenceId}/by-reference-id")
	public ResponseEntity<GetChannelResponse> getChannelByReferenceId(@PathVariable String clientReferenceId) {
		Channel channel = channelService.getChannelByReferenceId(getAuthenticatedApp(), clientReferenceId);
		return ResponseEntity.status(HttpStatus.OK).body(GetChannelResponse.builder().channel(channel).build());
	}

	@PostMapping("/")
	public ResponseEntity<CreateChannelResponse> createChannel(@Valid @RequestBody CreateChannelRequest request) {
		Channel channel = channelService.createChannel(getAuthenticatedApp(), request);
		return ResponseEntity.ok(CreateChannelResponse.builder().channel(channel).build());
	}
}
