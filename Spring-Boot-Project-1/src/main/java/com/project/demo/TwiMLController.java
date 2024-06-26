package com.project.demo;

//import com.project.demo.service.TwilioLookupService;
import com.twilio.twiml.TwiMLException;
import com.twilio.twiml.VoiceResponse;
import com.twilio.twiml.voice.Say;
import com.twilio.twiml.voice.Pause;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/twiml")
public class TwiMLController {

//	private final TwilioLookupService twilioLookupService;
//
//    @Autowired
//    public TwiMLController(TwilioLookupService twilioLookupService) {
//        this.twilioLookupService = twilioLookupService;
//    }
    
    @GetMapping("/hello")
    public ResponseEntity<String> sayHelloGet() {
        // Create a TwiML response for GET request
        VoiceResponse response = new VoiceResponse.Builder()
                .say(new Say.Builder("Hello! This is a GET request message from your Twilio application.").build())
                .pause(new Pause.Builder().length(5).build()) // Pause for 5 seconds
                .build();
        
        try {
            return ResponseEntity.ok(response.toXml());
        } catch (TwiMLException e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/hello")
    public ResponseEntity<String> sayHelloPost() {
        // Create a TwiML response for POST request
    	//String location = twilioLookupService.getCallerLocation(from);@RequestParam("From") String from
        VoiceResponse response = new VoiceResponse.Builder()
                .say(new Say.Builder("Hello! pavan. Em pikuthunnavu. Pharmacy valu ela vunnaru").build())
                .pause(new Pause.Builder().length(5).build()) // Pause for 5 seconds
                .build();
        

        try {
            return ResponseEntity.ok(response.toXml());
        } catch (TwiMLException e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
