package org.example.sealed2.service;

abstract public sealed class Result permits ResultExtraInfo, ResultInvalid, ResultSimple {
}
