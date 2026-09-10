package com.example.demo.common.mediator;

public interface IRequestHandler<T extends IRequest<R>, R> {

    R handle(T request);

    Class<T> getRequestType();

}
