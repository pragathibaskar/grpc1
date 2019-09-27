package com.cg.contService.grpc;
import com.cg.grpc.ProvisionServiceGrpc.ProvisionServiceImplBase;
import com.cg.grpc.request;
import com.cg.grpc.response;

import io.grpc.stub.StreamObserver;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class ProvisionServiceImpl extends ProvisionServiceImplBase {
	
public void creation(request req,StreamObserver<response> res) {
		
		response.Builder build = response.newBuilder();
		Date date = new Date(req.getTimestamp());  
		    SimpleDateFormat formatter = new SimpleDateFormat("MM dd yyyy");  
		    String strDate= formatter.format(date);   
		String codigo = req.getCodigo();
		String msg = "Provisión creada para el expediente "+codigo+" en el periodo "+strDate;
		System.out.println("message "+msg);
		build.setMsg(msg);
		response b = build.build();
		res.onNext(b);
		res.onCompleted();
		
	}

}
