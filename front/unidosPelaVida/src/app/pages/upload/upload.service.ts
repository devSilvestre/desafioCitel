import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { UploadForm } from 'src/app/shared/models/model/uploadForm.model';

@Injectable()
export class UploadService {

  constructor(private http: HttpClient) { }


  upload(json: Array<UploadForm>):Observable<any>{
    return this.http.post(`${environment.URL}upload`,JSON.stringify(json));
  }
}