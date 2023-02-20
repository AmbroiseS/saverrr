import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { Saverr } from './model/saverr';


@Injectable()
export class ApiServices {
    constructor(private http: HttpClient) { }


    httpOptions = {
        headers: new HttpHeaders({
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin' :'*'
        }),
    };

    /**
     * generateNewMessage
     */
    generateMessage(): Observable<Saverr> {
        return this.http.get<Saverr>(environment.apiUrl + '/gen', this.httpOptions)
    }

}