import { AuthorizeLvlService } from './../../../../../core/services/Purchase/authorize-lvl.service';
import { AuthorizeSignatory } from './../../../../../core/models/Purchase/authorize-signatory';
import { Component, OnInit, Input } from '@angular/core';
import { NzModalRef, NzMessageService } from 'ng-zorro-antd';
import { AuthLvlAddModalComponent } from '../../../authorize-lvl/components/auth-lvl-add-modal/auth-lvl-add-modal.component';
import { AuthorizeSignatoryService } from 'src/app/core/services/Purchase/authorize-signatory.service';

@Component({
  selector: 'app-auth-sign-add-modal',
  templateUrl: './auth-sign-add-modal.component.html',
  styleUrls: ['./auth-sign-add-modal.component.less']
})
export class AuthSignAddModalComponent implements OnInit {


	authLvls: any = [];
	authSign: AuthorizeSignatory = new AuthorizeSignatory();

  constructor(
		private modalRef: NzModalRef<AuthLvlAddModalComponent>,
		private message: NzMessageService,
		private authSignService: AuthorizeSignatoryService,
		private authLvlService: AuthorizeLvlService
		) { }

  ngOnInit() {
this.getAllAuthLvl();
	}

	saveAuthSign(){
		// console.log(this.authLvl);
		this.authSignService.saveAuthSign(this.authSign).subscribe(
			data => {
				// console.log(data['status']+"data");
				this.message.create('success', `Authorize Signatory Successfully Added!`,{nzDuration:3000});
				this.modalRef.triggerOk();
			},
			error => {
				// console.log(error['status']+"error");
				// console.log(error);
				// this.message.create('success', `Authorize Signatory Successfully Added!`);
				this.message.create('error', `Authorize Signatory Not Added!`,{nzDuration:3000});
			}
		);

		// this.modalRef.close();

}
onCancel() {
	this.modalRef.triggerCancel();
}

public getAllAuthLvl(){
	this.authLvlService.getAllAuthLvl().subscribe(
			data => {
					this.authLvls = data;


			},
			error => {

				if(error['status']=='404'){
					this.authLvls = [];
				}
					else if(error.error){
					this.authLvls = error.error;
			}



			}
	);
}


}
