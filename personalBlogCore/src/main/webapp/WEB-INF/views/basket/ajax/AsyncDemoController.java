package org.java.controller.ajax;

import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AsyncDemoController {

	private final Queue<DeferredResult<ModelAndView>> eventQueue = new ConcurrentLinkedQueue<>();

	@RequestMapping("/normal")
	public String normalCall() throws InterruptedException {
		Thread.sleep(9000);
		return "normal";
	}

	@RequestMapping("/async")
	public Callable<String> asyncCall(final Model model) {
		return new Callable<String>() {
			@Override
			public String call() throws Exception {
				Thread.sleep(9000);
				return "async";
			}
		};
	}

	@RequestMapping("/deferred")
	public @ResponseBody
	DeferredResult<ModelAndView> deferredCall() {
		DeferredResult<ModelAndView> result = new DeferredResult<>();
		this.eventQueue.add(result);
		return result;
	}

	@Scheduled(fixedRate = 5000)
	public void simulateExternalThread() throws InterruptedException {
		Thread.sleep(9000);
		for (DeferredResult<ModelAndView> result : this.eventQueue) {
			result.setResult(new ModelAndView("deferred"));
			this.eventQueue.remove(result);
		}
	}

}